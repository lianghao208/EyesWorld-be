package org.tvos.listener;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tvos.dao.QueryForTokenDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomListener implements ServletContextListener {
    ListenerThread t=new ListenerThread();


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        QueryForTokenDao dao=
                WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(QueryForTokenDao.class);
        t.setDao(dao);

        System.out.println("listener:context init");
        System.out.println(dao!=null);
        t.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener:context destroy");
        t.interrupt();

    }
}

class ListenerThread extends Thread{

    private QueryForTokenDao dao;


    public ListenerThread() {
    }

    public ListenerThread(QueryForTokenDao dao) {
        this.dao = dao;
    }

    public void setDao(QueryForTokenDao dao) {
        this.dao = dao;
    }

    @Override
    public void run() {
        /*int i=0;
        while(true) {
            System.out.println(jdbcTemplate==null);
            if(jdbcTemplate!=null){
                jdbcTemplate.update("insert into test values(null,?)",i++);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        long time;
        long delta;
        Date date;
        while(!isInterrupted()){
            //jdbcTemplate.update("delete from ");
            //System.out.println("a");
            try {
                date=dao.getOldestTime();
                if(date!=null) {
                    time = date.getTime();
                    delta = System.currentTimeMillis() - time;
                    if (delta > 60000) {
                        dao.deleteOldestToken();
                        System.out.println("token deleted");
                    }
                }
                deleteOverdueFile();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
        System.out.println("thread end");
    }

    private void deleteOverdueFile(){
        String dir="D:\\IntelliJ_Java_project\\tvos\\target\\tvos\\img";
        //String dir="C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\ROOT\\img";
        File dirFile=new File(dir);
        String fileName;
        long modTime;
        //System.out.println("dir exist:"+dirFile.exists());
        if(dirFile.exists()){
            File[] files=dirFile.listFiles();
            for(File f:files){
                modTime=f.lastModified();
                //System.out.println("file name"+f.getName());
                //System.out.println("mod time"+modTime);
                //System.out.println("delta"+(Calendar.getInstance().getTimeInMillis()-modTime));
                if((Calendar.getInstance().getTimeInMillis()-modTime)>60000){
                    f.delete();
                }
            }
        }
    }
}

