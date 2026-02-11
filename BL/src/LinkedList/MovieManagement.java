package LinkedList;

import java.util.Arrays;

class Movie{
    String movieTitle;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;
    Movie(String movieTitle, String director,int year, double rating){
        this.movieTitle=movieTitle;
        this.director=director;
        this.year=year;
        this.rating=rating;
        next=null;
    }
}
class MovieList{
    Movie head;
    void addFirst(Movie m){
        m.next=head;
        head=m;
    }

    void addEnd(Movie m){
        Movie curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=m;
        m.next=null;
    }
    void addBetween(Movie m, int index){
        Movie curr=head;

        for(int i=0; i<index-1&&curr!=null ; i++){
            curr=curr.next;
        }
        if(curr!=null){
            m.next=curr.next;
            curr.next=m;
        }
    }
    void remove(Movie m, int index){
        Movie curr=head;
        for(int i=0; i<index-1 && curr !=null ;i++){
            curr=curr.next;
        }
        if(curr.next!=null){
            curr.next=curr.next.next;
        }
    }
    void display(){
        Movie temp=head;
        while(temp!=null){
            System.out.println(temp.movieTitle+" "+ temp.director + " " + temp.year + " " + temp.rating);
            temp=temp.next;
        }
    }
}

public class MovieManagement {
    public static void main(String[] args){
        MovieList list=new MovieList();
        list.addFirst(new Movie("collage ", "Devraj" , 1992, 4.8));
        list.addEnd(new Movie("abode" , "Saatvik", 1993,4.8));
        list.addBetween(new Movie("movie","sss",1994,4.2),2);

        list.display();
    }


}
