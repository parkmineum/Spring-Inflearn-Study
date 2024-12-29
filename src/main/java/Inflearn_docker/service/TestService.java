package Inflearn_docker.service;

import Inflearn_docker.Repository.TestRepository;
import Inflearn_docker.model.TestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private TestRepository testRepository;

    public void create(String name, Integer age){
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public void update(Long id, String name, Integer age){
        TestEntity testEntity = testRepository.findById(id).orElseThrow();    // 해당 id가 없다면 예외 발생
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);    // 수정한 결과 DB 저장
    }

    public void delete(Long id){
        TestEntity testEntity = testRepository.findById(id).get();   // TestEntity 객체를 DB(리포지토리)에서 조회
        testRepository.delete(testEntity);
    }

    public List<TestEntity> findAllByNameByJPA(String name){
        return testRepository.findAllByName(name);
    }

    public List<TestEntity> findAllByNameByQueryDSL(String name){
        return testRepository.findAllByNameByQuerydsl(name);
    }
}
