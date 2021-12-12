/**
 * @ClassName Main
 * @Description TODO
 * @Author ZhuGuangLiang
 * @Date 2021/10/13 12:00
 */
public class Main {
    public void test(){
        int[] x={10,9,8,7,6,5};
        int l=0;
        int r= 1;
        int max=x.length;
        while(r<=max&&max>1){
            if(r==max){
                max--;
                l=0;
                r=1;
            }
            if(x[l]>x[r]){
                int mid=x[l];
                x[l]=x[r];
                x[r]=mid;
            }
            l++;
            r++;
        }
    }

    public static void main(String[] args) {
        new Main().test();

    }
}
