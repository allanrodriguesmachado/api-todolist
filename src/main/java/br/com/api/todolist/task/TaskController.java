package br.com.api.todolist.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/create")
    public ResponseEntity createTask(@RequestBody TaskModel taskModel) {

        System.out.println(taskModel.toString());

        // if (taskModel.equals("null")) {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar");
        // }

        var response = new HashMap<>();
        response.put("message", "USuario criado com sucesso");
        response.put("success", true);

        this.taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
