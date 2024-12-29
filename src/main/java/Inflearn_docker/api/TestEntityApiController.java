package Inflearn_docker.api;

import Inflearn_docker.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestEntityApiController {

    private TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ){
        testService.create(request.getName(), request.getAge());
    }

    @PutMapping("/test/entity/update/{id}")
    public void updateTestEntity(
            @PathVariable Long id,
            @RequestBody CreateTestEntityRequest request
    ){
        testService.update(id, request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ){
        testService.delete(id);
    }

    @Getter
    @AllArgsConstructor
    public static class CreateTestEntityRequest{
        private final String name;
        private final int age;
        // {
        //    "name" = "Jay",
        //    "age" = "26"
        // }
    }
}
