import java.util.*;

public class remove {
    public static void main(String[] args) {
        String[] exam = {"총맞은것처럼", "뱅뱅뱅", "빰", "안녕이란말헬로헬로","뱀","만수산 드렁 칡이"};  // 예시 문자열 배열
        // Array의 경우, Arrays.toString(event)로 와야 정상적으로 프린트 된다. 그냥 event를 넣으면 주소값이 반환된다.
        System.out.println(Arrays.toString(removeExtremes(exam)));
    }

    public static String[] removeExtremes(String[] arr) {
        /*
        1. 문자열을 순회하면서, 각 인덱스의 문자열을 순차적으로 비교
        2. 두 값중 작은 문자열은 min에, 큰 문자열은 max에 저장
        3. 값이 min과 max인 문자열을 제외한 array를 리턴
        4. 스트림 사용하여 필터링
        */
        if (arr.length==0) return null; //배열이 비어있으면 null 리턴
        String max = arr[0]; //현재까지 제일 큰 문자열. 초기값은 arr의 처음 값
        String min = arr[0]; //현재까지 제일 작은 문자열. 초기값은 arr의 처음 값
        for(int i=0 ; i<arr.length ; i++) {
            if(max.length() <= arr[i].length()) max=arr[i]; // 후순위로 오는 문자열의 길이가 크거나 같으면 뒤에 오는 것으로 대체
            if(min.length() >= arr[i].length()) min=arr[i]; // 후순위로 오는 문자열의 길이가 작거나 같으면 뒤에 오는 것으로 대체
        }

        // 람다식을 사용할 외부변수는 모두 레퍼런스 타입이 아니거나 final로 선언되어야 함
        final String finalMax = max;
        final String finalMin = min;

        // 문자열을 비교할 경우, ==이 아닌 .equals()를 사용해야함. 즉,a->a !=변수명 대신 a->!변수명.equals(a)
        return Arrays.stream(arr).filter(a-> !finalMax.equals(a)).filter(a-> !finalMin.equals(a)).toArray(String[]::new);
    }
}
