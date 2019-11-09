import java.util.Scanner;
//输入连续字符串，找到连续最长的字符串
//abcd12345ed125ss123456789
//123456789
public class Solution {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String string=input.nextLine();
        //先判断字符串是否为空
        if(string==" "){
            System.out.println(" ");
        }
        //如果超出长度改如何解决
        if(string.length()>255){
            System.out.println("超出长度");
        }
        char[] c=string.toCharArray();
        //数字串个数
        int sum=0;
        //存放数字串
        String b="";
        //存放最长数字串
        String longS="";
        //最长字符串个数
        int max=0;
        //循环遍历字符数组
        for(int i=0;i<=c.length-1;i++){
            //是数字
            if('0'<=c[i]&&c[i]<='9'){
                sum++;
                //如果最后一个字符也是数字
                if(i==c.length-1){
                    //再次比较
                    if(max<sum){
                        max=sum;
                        //范围变了，这这时的c[i]也是数字应该再范围内，
                        // 下面else中的c[i]不在范围内，是数字串结束后紧接的字符
                        longS=string.substring(i-sum+1,i+1);
                    }
                }
            }else{
                //需判断sum>0，因为第一个字符可能就不是数字，
                // 如果第一个字符不是数字，就直接遍历for循环，直到找到第一个数字
                //只有找到了数字串才执行比较切割
                if(sum>0){
                    b=string.substring(i-sum,i);
                    if(max<sum){
                        max=sum;
                        longS=b;
                        //一次数字串计数比较完成后，将b置空
                        b="";
                    }
                    //sum也置空，准备寻找下一次字符串
                    sum=0;
                }
            }
        }
        System.out.println(longS);
    }
}
