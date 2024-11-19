package org.example.ll;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        class WiseSaying {
            private int id;
            private String saying;
            private String author;

            public WiseSaying(int id, String saying, String author) {
                this.id = id;
                this.saying = saying;
                this.author = author;
            }


        }
        Scanner sc = new Scanner(System.in);
        ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
        int index = 1;
        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");
            String order = sc.nextLine();

            if (order.equals("종료")) {
                break;
            } else if (order.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                wiseSayingList.add(new WiseSaying(index, saying, author));
                System.out.println(index + "번 명언이 등록되었습니다.");
                index++;
            } else if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");
                for (WiseSaying wiseSaying : wiseSayingList) {
                    int id = wiseSaying.id;
                    String saying = wiseSaying.saying;
                    String author = wiseSaying.author;
                    System.out.println(id + " / " + saying + " / " + author);
                }
            }
        }
    }
}