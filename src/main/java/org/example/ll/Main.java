package org.example.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String wiseSayingList[] = new String[10];
        String authorList[] = new String[10];
        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");
            String text = sc.nextLine();

            if (text.equals("종료")) {
                break;
            } else if (text.equals("등록")) {
                System.out.print("명언 : ");
                wiseSayingList[count] = sc.nextLine();
                System.out.print("작가 : ");
                authorList[count] = sc.nextLine();
                count++;
                System.out.println(count + "번 명언이 등록되었습니다.");
            } else if (text.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------");
                for (int i = count; i >= 1; i--) {
                    System.out.println(i + " / " + authorList[i - 1] + " / " + wiseSayingList[i - 1]);
                }
            }
        }
    }
}