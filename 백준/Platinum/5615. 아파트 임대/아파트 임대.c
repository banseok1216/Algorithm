#include <stdio.h>
#define ui unsigned int
#define ull unsigned long long
int a_list[3] = {2, 7, 61};
ui pow(ull a, ui b, ui mod){
    ull result = 1;
    while (b){
        if (b & 1) result = result*a %mod;
        b >>= 1;
        a = a*a %mod;
    }
    return result;
}
int miller_rabin(ui n, int a){
    if (a%n == 0) return 1;
    ui d = n - 1;
    while (d % 2 == 0){
        if (pow(a, d, n) == n-1)
            return 1;
        d /= 2;
    }
    ui temp = pow(a, d, n);
    return temp == 1 || temp == n-1;
}
int prime(ui n){
    for (int i = 0; i < 3; i++)
        if (!miller_rabin(n, a_list[i]))
            return 0;
    return 1;
}
int main(){
    int N, cnt = 0;
    scanf("%d", &N);
    while (N--){
        ui val;
        scanf("%u", &val);
        if (prime(2*val + 1)) cnt++;
    }
    printf("%d", cnt);
}