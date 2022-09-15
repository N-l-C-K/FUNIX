import java.util.Scanner;

public class GradeStudent {

    public static int weightMid;        //Trọng số của điểm thi giữa kỳ
    public static int weightFinal;      //Trọng số của điểm thi cuối kỳ
    public static int weightHw;         //Trọng số của điểm bài tập về nhà
    public static double weightedMid;   //Điểm số đã tính dựa trên weightMid
    public static double weightedFinal; //Điểm số đã tính dựa trên weightFinal
    public static double weightedHw;    //Điểm số đã tính dựa trên weightHw
    public static double overall;       //Tổng điểm 3 môn tính theo thang điểm 100
    public static void main(String[] args) {
        begin();
        System.out.println();
        midTerm();
        System.out.println();
        finalTerm();
        System.out.println();
        homework();
        System.out.println();
        report();
    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    public static double midTerm () {
        Scanner input = new Scanner(System.in);
        int shiftedAmount = 0;    //Số điểm được tăng

        System.out.println("Midterm:");

        //Nhập trọng số của điểm thi giữa kỳ
        System.out.print("Weight (0-100)? ");
        weightMid = input.nextInt();

        //Nếu trọng số được nhập vào không hợp lệ thì sẽ nhập lại
        while (weightMid >= 100) {
            System.out.println("Invalid input, please re-enter.");
            weightMid = input.nextInt();
        }
        
        //Nhập điểm số người dùng đạt được
        System.out.print("Score earned? ");
        int scEarned = input.nextInt();

        //Điểm thi của bạn có tăng hay không. Nếu có thì nhập số điểm được tăng
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int scShifted = input.nextInt();
        if (scShifted == 1) {
            System.out.print("Shift Amount? ");
            shiftedAmount = input.nextInt();
        }
        
        //Điểm đạt được nếu lớn hơn 100 thì vẫn tính là 100
        scEarned = scEarned + shiftedAmount;
        if (scEarned > 100) {
            scEarned = 100;
        }

        System.out.println("Total points = " + scEarned + " / 100");
        
        //Tính số điểm dựa trên trọng số trọng số weightMid
        weightedMid = (scEarned/100.0)*weightMid;
       
        System.out.println("Weighted score = " + (double) Math.round(weightedMid * 10)/10 + " / " + weightMid); 

        //input.close();
        return weightedMid;
    }

    public static double finalTerm() {
        Scanner input = new Scanner(System.in);
        int shiftedAmount = 0;  //Số điểm được tăng

        System.out.println("Final:");

        //Nhập trọng số của điểm thi cuối kỳ
        System.out.print("Weight (0-100)? ");
        weightFinal = input.nextInt();

        //Nếu trọng số được nhập vào không hợp lệ thì sẽ nhập lại
        while ((weightFinal + weightMid) >= 100) {
            System.out.println("Invalid input, please re-enter.");
            weightFinal = input.nextInt();
        }

        //Nhập điểm số người dùng đạt được
        System.out.print("Score earned? ");
        int scEarned = input.nextInt();

        //Điểm thi của bạn có tăng hay không. Nếu có thì nhập số điểm được tăng
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int scShifted = input.nextInt();
        if (scShifted == 1) {
            System.out.print("Shift Amount? ");
            shiftedAmount = input.nextInt();
        }

        //Điểm đạt được nếu lớn hơn 100 thì vẫn tính là 100
        scEarned = scEarned + shiftedAmount;
        if (scEarned > 100) {
            scEarned = 100;
        }

        System.out.println("Total points = " + scEarned + " / 100");
        
        //Tính số điểm dựa trên trọng số trọng số weightFinal
        weightedFinal = (scEarned/100.0)*weightFinal;
       
        System.out.println("Weighted score = " + (double) Math.round(weightedFinal * 10)/10 + " / " + weightFinal); 

        //input.close();
        return weightedFinal;
    }

    public static double homework() {
        Scanner input = new Scanner(System.in);
        int totalScores = 0;    //Tổng số điểm các bài Asm mà người dùng đạt được
        int totalMaxScores = 30; //Tổng số điểm tối đa của phần bài Asm
        int sectionPoint = 0;   //Tổng số điểm chuyên cần
        int totalPoint = 0;     //Tổng điểm số sinh viên đạt được

        System.out.println("Homework:");

        //Nhập trọng số của điểm bài tập về nhà
        System.out.print("Weight (0-100)? ");
        weightHw = input.nextInt();

        //Nếu trọng số được nhập vào không hợp lệ thì sẽ nhập lại
        while ((weightHw + weightFinal + weightMid) > 100 || (weightHw + weightFinal + weightMid) < 100) {
            System.out.println("Invalid input, please re-enter.");
            weightHw = input.nextInt();
        }


        //Nhập tổng số bài tập về nhà cần làm
        System.out.print("Number of assignments? ");
        int numOfAsm = input.nextInt();

        int[] asmScores = new int[numOfAsm];    //Khai báo mảng chứa các điểm số người dùng đạt được của từng bài Asm
        int[] asmMaxScores = new int[numOfAsm]; //Khai báo mảng chứa các điểm số tối đa của từng bài Asm

        //Gán các số điểm người dùng nhập vào mảng tương tự
        for (int i = 0; i < numOfAsm; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            asmScores[i] = input.nextInt();
            asmMaxScores[i] = input.nextInt();
        }

        //Tính tổng số điểm các bài Asm mà người dùng đạt được
        for (int i = 0; i < asmScores.length; i++) {
            totalScores += asmScores[i];
        }

        //Tính tổng số điểm tối đa của các bài Asm
        for (int i = 0; i < asmMaxScores.length; i++) {
            totalMaxScores += asmMaxScores[i];
        }

        //Nhập số buổi sinh viên đã đi học và được điểm danh
        System.out.print("How many sections did you attend? ");
        int section = input.nextInt();

        //Tính tổng số điểm chuyên cần
        sectionPoint = section * 5;
        //Nếu số điểm chuyên cần lớn hơn 30 thì vẫn tính là 30
        if (sectionPoint > 30) {
            sectionPoint = 30;
        }

        //Tổng số điểm phần Asm
        totalPoint = totalScores + sectionPoint;
        
        //Nếu tổng điểm tối đa của phần Asm lớn hơn 150 thì vẫn tính là 150
        if (totalMaxScores > 150) {
            totalMaxScores = 150;
        }

        //Nếu tổng điểm Asm sinh viên đạt được lớn hơn 150 thì vẫn tính là 150
        if (totalPoint > 150) {
            totalPoint = 150;
        }

        System.out.println("Section points = " + sectionPoint + " / 30");
        System.out.println("Total points = " + totalPoint + " / " + totalMaxScores);

        //tính số điểm dựa trên trọng số weightHw
        weightedHw = (totalPoint / (totalMaxScores * 1.0)) * weightHw; 
        
        System.out.println("Weighted score = " + (double) Math.round(weightedHw * 10)/10 + " / " + weightHw);

        //input.close();
        return weightedHw;
    }

    public static void report() {   
        overall = (double) Math.round((weightedMid + weightedFinal + weightedHw) * 10)/10;
        System.out.println("Overall percentage = " + overall);
        if (overall >= 85) {
            System.out.println("Your grade will be at least: 3.0");
            System.out.println("<< You have done very well >>");
        } else if (overall >= 75 && overall <85) {
            System.out.println("Your grade will be at least: 2.0");
            System.out.println("<< You have done well >>");
        } else if (overall >= 60 && overall < 75) {
            System.out.println("Your grade will be at least: 1.0");
            System.out.println("<< You have tried your best >>");
        } else {
            System.out.println("Your grade will be at least: 0.0");
            System.out.println("<< You haven't tried your best >>");
        }
    }
}