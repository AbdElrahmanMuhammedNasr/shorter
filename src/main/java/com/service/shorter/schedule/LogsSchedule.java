//package com.service.shorter.schedule;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@Component
//public class LogsSchedule {
//
////    @Scheduled(fixedRate = 5000)
//    public void readNginxAccessLog() {
//        try {
//            ClassPathResource resource = new ClassPathResource("var/log/nginx/access.log");
//            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
//
//            BufferedReader br = new BufferedReader(reader);
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println("Nginx Access Log: " + line);
//                System.out.println(line);
//                System.out.println("Nginx Access Log: " + line);
//            }
//             br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
