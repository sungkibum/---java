package org.example.ll;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");
            String text = sc.nextLine();

            if (text.equals("종료")) {
                break;
            } else if (text.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                count++;
                System.out.println(count + "번 명언이 등록되었습니다.");
            }
        }
    }
}