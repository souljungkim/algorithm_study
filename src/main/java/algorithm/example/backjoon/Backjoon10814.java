package algorithm.example.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Backjoon10814 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        StringTokenizer st;
        int input = Integer.parseInt(br.readLine());
        UserList userList = new UserList(input);
        int age;
        String name;
        for (int i=0; i<input; i++){
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            userList.add(new User(i, age, name));
        }

        userList.sort();

        System.out.println(userList);
    }





    static class UserList {

        UserList(int size){
            this.size = size;
            this.users = new User[size];
        }

        private User[] users;
        private int size = -1;
        private int index = -1;
        public void add(User user){
            this.users[++this.index] = user;
        }
        public void sort(){
            Arrays.sort(this.users, new Comparator<User>(){
               public int compare(User a, User b){
                   if (a.getAge() == b.getAge()){
                       return a.getSignSeq() - b.getSignSeq();
                   }else{
                       return a.getAge() - b.getAge();
                   }
               }
            });
        }
        public String toString(){
            String enter = System.lineSeparator();
            StringBuilder sb = new StringBuilder();
            User user;
            for (int i=0; i<this.index +1; i++){
                user = this.users[i];
                sb.append(user.getAge()).append(" ").append(user.getName()).append(enter);
            }
            return sb.toString();
        }
    }

    static class User {
        User(int signSeq, int age, String name){
            this.signSeq = signSeq;
            this.age = age;
            this.name = name;
        }
        private int signSeq;
        private int age;
        private String name;
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public int getSignSeq(){
            return signSeq;
        }
    }

}


