import java.util.Random;
import java.util.Scanner;

public class LuckyNumber {

    public static int totalGames;  //Tổng số lượt chơi
    public static int totalGuess;  //Tổng số lần đoán
    public static double guessAvg; //Số lần dự đoán trung bình mỗi lượt
    public static int bestGame;    //Số lần dự đoán đúng ít nhất

    public static void main(String args[]) {
        play();
        report();    
    }
    
    public static void play() {
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
    
        int maxNum = 100;   //Định nghĩa số lớn nhất trong phạm vi dự đoán
        String rightAnswer1 = "y";  //Câu trả lời được chấp thuận để tiếp tục chơi
        String rightAnswer2 = "yes";    //Câu trả lời được chấp thuận để tiếp tục chơi
        String answer;  //Câu trả lời đồng ý chơi tiếp hay dừng chơi

        do {
            int rdNum = rd.nextInt(maxNum) + 1; //Trả về 1 số nguyên nằm trong phạm vi [0...100]
            int guess = 1;  //Đếm số lần dự đoán mỗi lượt chơi

            System.out.println("Tôi đang nghĩ đến một số từ 0 dến " + maxNum);
            System.out.print("Dự đoán của bạn là? ");
            int guessNum = input.nextInt(); //Con số dự đoán của người chơi nhập vào

            //Nếu con số dự đoán của người chơi không trùng với con số random thì đưa ra các gợi ý
            while (guessNum != rdNum) {
                if (guessNum > rdNum) {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                    guess += 1;
                    System.out.print("Dự đoán của bạn là? ");
                    guessNum = input.nextInt();
                } else if (guessNum < rdNum) {
                    System.out.println("số may mắn lớn hơn số dự đoán của bạn.");
                    guess += 1;
                    System.out.print("Dự đoán của bạn là? ");
                    guessNum = input.nextInt();
                } 
            }

            //Nếu con số dự đoán của người chơi trùng với con số random thì đưa ra thông báo 
            if (guessNum == rdNum) {
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + guess + " lần dự đoán.");
            }  
            
            //Xác định số lần dự đoán đúng ít nhất
            bestGame = guess;
            if (bestGame > guess) {
                bestGame = guess;
            }

            totalGames += 1;    //Đếm tổng số lần chơi
            totalGuess += guess;    //Đếm tổng số lần đoán

            System.out.println("Bạn có muốn tiếp tục chơi không?");
            answer = input.next();

          //Nếu câu trả lời là “y”, “Y”, “yes”, “YES”, “Yes” thì tiếp tục chơi
        } while (answer.equalsIgnoreCase(rightAnswer1) || answer.equalsIgnoreCase(rightAnswer2)); 
        
        input.close();
    }

    public static void report() {
        guessAvg = (double) totalGuess/totalGames;  //Tính số lần đoán trung bình mỗi lượt
        System.out.println("========================================================");
        System.out.println("Kết quả tổng quát:");
        System.out.println("Tổng số lần chơi = " + totalGames);
        System.out.println("Tổng số lần dự đoán = " + totalGuess);
        System.out.println("Số lần dự doán trung bình mỗi lượt = " + ((double) Math.round(guessAvg * 10) / 10));
        System.out.println("Số lần dự đoán ít nhất = " + bestGame);
    }
    
}