package bridge;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String MIDDLE_BRIDGE = " | ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge) {
        printMapUp(bridge);
        printMapDown(bridge);
    }

    private static void printMapUp(List<String> bridge) {
        List<String> upBridge = bridge.stream()
                .map(Validate::isUp)
                .collect(Collectors.toList());
        System.out.println(START_BRIDGE + String.join(MIDDLE_BRIDGE, upBridge) + END_BRIDGE);
    }
    private static void printMapDown(List<String> bridge) {
        List<String> downBridge = bridge.stream()
                .map(Validate::isDown)
                .collect(Collectors.toList());
        System.out.println(START_BRIDGE + String.join(MIDDLE_BRIDGE, downBridge) + END_BRIDGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge, int retCnt, String res) {
        System.out.println("최종 게임 결과");
        printMap(bridge);
        System.out.println();
        System.out.println("게임 성공 여부: " + res);
        System.out.println("총 시도한 횟수: " + retCnt);
    }
}
