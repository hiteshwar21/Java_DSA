package Arrays;


public class demo {
        public static void main(String[] args) {
            String s = "?RW?WR";
            String t = "?WR?RW";
            int n = s.length();
            int c = 0, r1 = 0, r2 = 0, w1 = 0, w2 = 0, q = 0, f = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'R') {
                    r1++;
                    if (t.charAt(i) == 'W') {
                        w2++;
                    } else if (t.charAt(i) == '?') {
                        c++;
                        t = t.substring(0, i) + 'W' + t.substring(i + 1);
                        w2++;
                    } else {
                        f = 1;
                        break;
                    }
                } else if (s.charAt(i) == 'W') {
                    w1++;
                    if (t.charAt(i) == 'R') {
                        r2++;
                    } else if (t.charAt(i) == '?') {
                        c++;
                        t = t.substring(0, i) + 'R' + t.substring(i + 1);
                        r2++;
                    } else {
                        f = 1;
                        break;
                    }
                } else {
                    if (s.charAt(i) == '?') {
                        if (t.charAt(i) == 'R') {
                            c++;
                            r2++;
                            s = s.substring(0, i) + 'W' + s.substring(i + 1);
                            w1++;
                        } else if (t.charAt(i) == 'W') {
                            c++;
                            w2++;
                            s = s.substring(0, i) + 'R' + s.substring(i + 1);
                            r1++;
                        } else {
                            q++;
                        }
                    }
                }
            }

            if (f == 1) {
                System.out.println(-1);
            } else {
                if (Math.abs(r1 - r2) > q) {
                    System.out.println(-1);
                } else {
                    System.out.println(c + 2 * Math.abs(r1 - r2));
                }
            }
        }
    }
