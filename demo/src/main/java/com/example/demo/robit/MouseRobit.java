package com.example.demo.robit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.InputEvent;

@Component
public class MouseRobit {

     int i = 1;
    @Scheduled(fixedRate = 2000)
    public void t() throws AWTException {
        Robot robot = new Robot();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height;//获取屏幕的高

        robot.mouseMove(screenWidth/2, screenHeight/2);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("点击了"+(i++)+"次");
    }
}
