// --- 1. MemberRepository.java (인터페이스) ---
package step2;
import domain.Member;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findByName(String name);
}

// --- 2. MemoryMemberRepository.java ---
package step2;
import domain.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getName(), member);
        System.out.println("[Memory] 실제 데이터 저장: " + member.getName());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return Optional.ofNullable(store.get(name));
    }
}

// --- 3. MockMemberRepository.java ---
package step2;
import domain.Member;
import java.util.Optional;

public class MockMemberRepository implements MemberRepository {
    @Override
    public void save(Member member) {
        System.out.println("[Mock] 가짜 저장: " + member.getName());
    }
    @Override
    public Optional<Member> findByName(String name) {
        if ("Dummy".equals(name)) {
            return Optional.of(new Member("Dummy"));
        }
        return Optional.empty();
    }
}

// --- 4. MemberService.java ---
package step2;
import domain.Member;

public class MemberService {
    private final MemberRepository repository;

    // 생성자를 통한 의존성 주입 (DI)
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void register(String name) {
        if (repository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("[Step2] 이미 존재하는 이름입니다: " + name);
        }
        repository.save(new Member(name));
        System.out.println("[Step2] 회원 가입 완료: " + name);
    }
}

// --- 5. Main2.java ---
package step2;

public class Main2 {
    public static void main(String[] args) {
        // Main이 객체 생성과 조립을 담당함 (IoC)
        MemberRepository memoryRepo = new MemoryMemberRepository();
        MemberService service = new MemberService(memoryRepo); // 여기서 쏙 넣어줌 (DI)

        service.register("Bob");
    }
}