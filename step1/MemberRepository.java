// --- 1. MemberRepository.java ---
package step1;
import domain.Member;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    private final Map<String, Member> store = new HashMap<>();

    public void save(Member member) {
        store.put(member.getName(), member);
    }
    public Member findByName(String name) {
        return store.get(name);
    }
}

// --- 2. MemberService.java ---
package step1;
import domain.Member;

public class MemberService {
    // Service가 직접 객체를 생성함 (강한 결합)
    private final MemberRepository repository = new MemberRepository();

    public void register(String name) {
        if (repository.findByName(name) != null) {
            throw new IllegalArgumentException("[Step1] 이미 존재하는 이름입니다: " + name);
        }
        repository.save(new Member(name));
        System.out.println("[Step1] 회원 가입 완료: " + name);
    }
}

// --- 3. Main1.java ---
package step1;

public class Main1 {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.register("Alice");
    }
}