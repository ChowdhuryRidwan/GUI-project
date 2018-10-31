package sample;
import java.lang.*;
import java.util.Random;

public class ComplexNumber {
    // create instance of Random class
    Random rand = new Random();
    int c, e, f, d;
    String strc, strd, stre, strf, result,ques;

    // Generate random integers in range -5 to 5
    ComplexNumber() {
        do {
            c = rand.nextInt(5 + 1 - (-5)) + (-5);
        }
        while(c==0);

        do {
            e = rand.nextInt(5 + 1 - (-5)) + (-5);
        }
        while (c == -e && e==0);

        do {
            f = rand.nextInt(5 + 1 - (-5)) + (-5);
        }
        while (f==0);

        do {
            d = rand.nextInt(5 + 1 - (-5)) + (-5);
        }
        while (d == -f && d==0);
        strc = Integer.toString(c);
        strd = Integer.toString(d);
        stre = Integer.toString(e);
        strf = Integer.toString(f);
        ques="("+strc+"+"+strd+"i"+")"+"+"+"("+stre+"+"+strf+"i"+")";
        int a_real = Integer.parseInt(strc);
        // Storing the imaginary part of complex string a
        int a_img = Integer.parseInt(strd);
        // Storing the dddreal part of complex string b
        int b_real = Integer.parseInt(stre);
        // Storing the imaginary part of complex string b
        int b_img = Integer.parseInt(strf);
        // Returns the sum.
        if((b_img+a_img)<0)
        {
            result = (a_real + b_real) +
                    (b_img + a_img) + "i";
        }
        else if((b_img+a_img)==0)
        {
            result = (a_real + b_real) + "+" + "i";
        }
        else if((a_real+b_real)==0)
        {
            result = (b_img + a_img) + "i";
        }
        else {
            result = (a_real + b_real) + "+" +
                    (b_img + a_img) + "i";
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }
}

