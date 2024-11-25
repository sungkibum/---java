package org.example.ll;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        // 디렉토리 생성
        String dirPath = "db/wiseSaying";
        File dir = new File(dirPath);
        if (!dir.exists()) dir.mkdirs();

        ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int index = 1;

        // 프로그램 시작 시 파일에서 데이터 로드
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    int id = Integer.parseInt(reader.readLine());
                    String saying = reader.readLine();
                    String author = reader.readLine();
                    wiseSayingList.add(new WiseSaying(id, saying, author));
                    index = Math.max(index, id + 1); // 마지막 ID를 기준으로 인덱스 설정
                } catch (IOException e) {
                    System.out.println("파일 읽기 실패: " + file.getName());
                }
            }
        }

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

                WiseSaying newWiseSaying = new WiseSaying(index, saying, author);
                wiseSayingList.add(newWiseSaying);

                // 파일에 저장
                try (FileWriter writer = new FileWriter(dirPath + "/" + index + ".txt")) {
                    writer.write(newWiseSaying.toString());
                } catch (IOException e) {
                    System.out.println("파일 저장 실패: " + index + ".txt");
                }

                System.out.println(index + "번 명언이 등록되었습니다.");
                index++;
            } else if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");
                for (WiseSaying wiseSaying : wiseSayingList) {
                    System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getSaying());
                }
            } else if (order.equals("삭제")) {
                System.out.print("?id=");
                int idNum = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                boolean check = false;
                for (WiseSaying wiseSaying : wiseSayingList) {
                    if (idNum == wiseSaying.getId()) {
                        wiseSayingList.remove(wiseSaying);
                        File fileToDelete = new File(dirPath + "/" + idNum + ".txt");
                        if (fileToDelete.exists()) fileToDelete.delete();
                        System.out.println(idNum + "번 명언이 삭제되었습니다.");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    System.out.println(idNum + "번 명언은 존재하지 않습니다.");
                }
            } else if (order.equals("수정")) {
                System.out.print("?id=");
                int idNum = sc.nextInt();
                sc.nextLine();
                boolean check = false;
                for (WiseSaying wiseSaying : wiseSayingList) {
                    if (idNum == wiseSaying.getId()) {
                        System.out.println("명언(기존) : " + wiseSaying.getSaying());
                        System.out.print("명언 : ");
                        String newSaying = sc.nextLine();
                        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();

                        // 데이터 수정
                        wiseSaying.saying = newSaying;
                        wiseSaying.author = newAuthor;

                        // 파일 갱신
                        try (FileWriter writer = new FileWriter(dirPath + "/" + idNum + ".txt")) {
                            writer.write(wiseSaying.toString());
                        } catch (IOException e) {
                            System.out.println("파일 갱신 실패: " + idNum + ".txt");
                        }

                        System.out.println(idNum + "번 명언이 수정되었습니다.");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    System.out.println(idNum + "번 명언은 존재하지 않습니다.");
                }
            }
        }
    }
}
