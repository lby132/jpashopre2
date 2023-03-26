package jpashopre.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SimpleOrderQueryRepository {

    private final EntityManager em;

    public List<SimpleOrderQueryDto> findOrderDtos() {
        return em.createQuery("select jpashopre.repository.order.simplequery(o.id, m.name, o.orderDate, o.status, o.address) from Order o" +
                " join o.member m" +
                " join o.delivery d", SimpleOrderQueryDto.class)
                .getResultList();
    }
}
