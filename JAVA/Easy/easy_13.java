public class easy_13 {

    public static void main(String[] args) {
        String s = "DCXXI";

        char[] clist = s.toCharArray();
        int cur = 0;
        int ans = 0;
        while (cur < clist.length) {
            switch (clist[cur]) {
                case 'I':
                    if (cur + 1 < clist.length) {
                        switch (clist[cur + 1]) {
                            case 'V':
                                ans += 4;
                                cur++;
                                break;
                            case 'X':
                                ans += 9;
                                cur++;
                                break;
                            default:
                                ans += 1;
                        }
                    } else
                        ans++;
                    break;
                case 'X':
                    if (cur + 1 < clist.length) {
                        switch (clist[cur + 1]) {
                            case 'L':
                                ans += 40;
                                cur++;
                                break;
                            case 'C':
                                ans += 90;
                                cur++;
                                break;
                            default:
                                ans += 10;
                        }
                    } else
                        ans += 10;
                    break;
                case 'C':
                    if (cur + 1 < clist.length) {
                        switch (clist[cur + 1]) {
                            case 'D':
                                ans += 400;
                                cur++;
                                break;
                            case 'M':
                                ans += 900;
                                cur++;
                                break;
                            default:
                                ans += 100;
                        }
                    } else
                        ans += 100;
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
                default:
                    return;
            }
            cur++;
        }
        System.out.println(ans);
    }
}
