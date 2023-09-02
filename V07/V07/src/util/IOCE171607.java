package util;

import java.util.Scanner;

/**
 *
 * @author NhutTMCE171607
 */
public class IOCE171607 {

    static Scanner sc = new Scanner(System.in);

    /**
     * Check the input is integer or not
     *
     * @param iMsg
     * @param iError
     * @return
     */
    public static int getInteger(String iMsg, String iError) {
        System.out.print(iMsg);
        int res = 0;
        while (true) {
            try {
                res = Integer.parseInt(sc.nextLine());
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * Check the input is integer or not and greater than the given number
     *
     * @param iMsg
     * @param iError
     * @param numbers
     * @return
     */
    public static int getGreaterInteger(String iMsg, String iError, int numbers) {
        System.out.print(iMsg);
        int res = 0;
        while (true) {
            try {
                res = Integer.parseInt(sc.nextLine());
                if (numbers > res) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * Limit integer range with start and end values
     *
     * @param iMsg
     * @param iError
     * @param start
     * @param end
     * @return
     */
    public static int getInteger(String iMsg, String iError, int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        System.out.print(iMsg);
        int res = 0;
        while (true) {
            try {
                res = Integer.parseInt(sc.nextLine());
                if (res < start || res > end) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * Check the input is double or not
     *
     * @param iMsg
     * @param iError
     * @return
     */
    public static double getDouble(String iMsg, String iError) {
        System.out.print(iMsg);
        double res = 0;
        while (true) {
            try {
                res = Double.parseDouble(sc.nextLine());
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * Check the input is double or not and greater than the given number
     *
     * @param iMsg
     * @param iError
     * @param number
     * @return
     */
    public static double getGreaterDouble(String iMsg, String iError, double number) {
        System.out.print(iMsg);
        double res = 0;
        while (true) {
            try {
                res = Double.parseDouble(sc.nextLine());
                if (res <= number) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * Limit double range with start and end values
     *
     * @param iMsg
     * @param iError
     * @param start
     * @param end
     * @return
     */
    public static double getDouble(String iMsg, String iError, double start, double end) {
        if (start > end) {
            double temp = start;
            start = end;
            end = temp;
        }
        System.out.print(iMsg);
        double res = 0;
        while (true) {
            try {
                res = Double.parseDouble(sc.nextLine());
                if (res < start || res > end) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /**
     * check input String is empty or not
     *
     * @param iMsg
     * @param iError
     * @return
     */
    public static String getString(String iMsg, String iError) {
        System.out.print(iMsg);
        while (true) {
            try {
                String res = sc.nextLine();
                if (res.trim().isEmpty()) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    /*
        (DOC) is required in the string
        [0-9] is 0 from 9 that whill appear in the string
        {3} is the length of the back part of the string
     */
    private static final String CODE_CHECK = "(DOC)[0-9]{3}";

    /**
     * Check 
     * @param iMsg
     * @param iError
     * @return
     */
    public static String getStringCodeCheck(String iMsg, String iError) {
        System.out.print(iMsg);
        while (true) {
            try {
                String res = sc.nextLine();
                if (!res.matches(CODE_CHECK)) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }

        }
    }
}
