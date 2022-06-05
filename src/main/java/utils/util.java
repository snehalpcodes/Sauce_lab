package utils;

public class util {

    public static boolean AscAlphabettically(String arr[])
    {
        if(arr.length==0 || arr.length==1)
        {
            return true;
        }
        for(int i=0;i< arr.length-1;i++)
        {
            String s1=arr[i].toUpperCase();
            String s2=arr[i+1].toUpperCase();
            if(s1.compareTo(s2)>0)
            {
                return false;

            }
        }
        return true;
    }

    public static boolean DescAlphabettically(String arr[])
    {
        if(arr.length==0 || arr.length==1)
        {
            return true;
        }
        for(int i=0;i< arr.length-1;i++)
        {
            String s1=arr[i].toUpperCase();
            String s2=arr[i+1].toUpperCase();
            if(s2.compareTo(s1)>0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean Ascno(double[] arr)
    {
        if (arr== null || arr.length <= 1)
        {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
    public static boolean descno(double[] arr)
    {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }

        return true;
    }



}


