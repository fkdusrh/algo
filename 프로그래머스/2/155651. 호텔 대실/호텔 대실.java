import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Book> books = convertToMinute(book_time);
        
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b1.getStartTime(), b2.getStartTime());
            }
        });
    
        
        List<List<Book>> rooms = new LinkedList<>(); 
        boolean success = false;

        for(Book book:books){//예약 건수
            success = false;
            for(List<Book> roomTimeTable:rooms){ // 방 타임 테이블
                if (roomTimeTable.isEmpty() || 
                    roomTimeTable.get(roomTimeTable.size() - 1).endTime + 10 <= book.startTime) {
                    roomTimeTable.add(book);
                    success=true;
                    break;
                }
                
                if(success)
                    break;
            }
            if(!success){
                rooms.add(new LinkedList<Book>());
                rooms.get(rooms.size()-1).add(book);
             }
        }
        
        return rooms.size();
    }
    
    public static List<Book> convertToMinute(String[][] book_time){
        List<Book> books = new LinkedList<>();
        for(String[] book : book_time){
            int startMin=calculate(book[0]);
            int endMin = calculate(book[1]);
            books.add(new Book(startMin,endMin));
        }
        return books;
    }
    public static int calculate(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        
        return hour*60 + minute;
    }
}

class Book{
    int startTime;
    int endTime;
    public Book(int start, int end){
        this.startTime = start;
        this.endTime = end;
    }
    
    public int getStartTime(){
        return this.startTime;
    }
}