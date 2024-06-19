import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Book> books = convertToMinute(book_time);

        // Book의 startTime을 기준으로 오름차순 정렬
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getStartTime(), b2.getStartTime());
            }
        });

        // 종료 시간을 기준으로 오름차순 정렬되는 PriorityQueue
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Book book : books) {
            // 가장 빨리 끝나는 방의 종료 시간을 가져옴
            if (!rooms.isEmpty() && rooms.peek() + 10 <= book.startTime) {
                // 기존 방에 현재 예약을 추가할 수 있는 경우
                rooms.poll(); // 해당 방의 종료 시간을 제거
            }
            // 새로운 종료 시간을 추가
            rooms.add(book.endTime);
        }

        // 필요한 방의 수는 PriorityQueue에 남아 있는 요소의 수와 같음
        return rooms.size();
    }

    public static List<Book> convertToMinute(String[][] book_time) {
        List<Book> books = new LinkedList<>();
        for (String[] book : book_time) {
            int startMin = calculate(book[0]);
            int endMin = calculate(book[1]);
            books.add(new Book(startMin, endMin));
        }
        return books;
    }

    public static int calculate(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + minute;
    }
}

class Book {
    int startTime;
    int endTime;

    public Book(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }

    public int getStartTime() {
        return this.startTime;
    }
}
