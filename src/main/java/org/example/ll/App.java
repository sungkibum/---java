package org.example.ll;

import org.example.ll.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    void run() {
        WiseSayingController wiseSayingController = new WiseSayingController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");
            String order = sc.nextLine();

            if (order.equals("종료")) {
                break;
            } else if (order.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (order.equals("목록")) {
                wiseSayingController.actionList();
            } else if (order.equals("삭제")) {
                wiseSayingController.actionDelete();
            } else if (order.equals("수정")) {
                wiseSayingController.actionModify();
            }
        }
    }
}
