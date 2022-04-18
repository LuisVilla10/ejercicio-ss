package mx.uv.t4is.tareas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.todo.AgregarToDoRequest;
import https.t4is_uv_mx.todo.AgregarToDoResponse;
import https.t4is_uv_mx.todo.EliminarToDoRequest;
import https.t4is_uv_mx.todo.EliminarToDoResponse;
import https.t4is_uv_mx.todo.ModificarToDoRequest;
import https.t4is_uv_mx.todo.ModificarToDoResponse;
import https.t4is_uv_mx.todo.ObtenerToDosResponse;

@Endpoint
public class TareasEndPoint {

    @Autowired
    private IToDo iToDo;
    
    @PayloadRoot(namespace = "https://t4is.uv.mx/todo", localPart = "AgregarToDoRequest")
    @ResponsePayload
    public AgregarToDoResponse agregarToDo(@RequestPayload AgregarToDoRequest peticion) {
        AgregarToDoResponse respuesta = new AgregarToDoResponse();

        List<AgregarToDoRequest.ToDo> todosPorAgregar = peticion.getToDo();

        for(AgregarToDoRequest.ToDo todoPorAgregar : todosPorAgregar) {
            ToDo todo = new ToDo();
            todo.setTarea(todoPorAgregar.getTarea());
            todo.setStatus(todoPorAgregar.getStatus());
            iToDo.save(todo);
        }

        respuesta.setRespuesta(true);

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/todo", localPart = "ObtenerToDosRequest")
    @ResponsePayload
    public ObtenerToDosResponse obtenerToDos() {
        ObtenerToDosResponse respuesta = new ObtenerToDosResponse();

        Iterable<ToDo> todos = iToDo.findAll();

        todos.forEach(todo -> {
            ObtenerToDosResponse.ToDo todoRespuesta = new ObtenerToDosResponse.ToDo();
            todoRespuesta.setId(todo.getId());
            todoRespuesta.setTarea(todo.getTarea());
            todoRespuesta.setStatus(todo.getStatus());

            respuesta.getToDo().add(todoRespuesta);
        });

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/todo", localPart = "EliminarToDoRequest")
    @ResponsePayload
    public EliminarToDoResponse eliminarToDo(@RequestPayload EliminarToDoRequest peticion) {
        EliminarToDoResponse respuesta = new EliminarToDoResponse();

        Integer id = peticion.getId();

        iToDo.deleteById(id);

        respuesta.setRespuesta(true);

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/todo", localPart = "ModificarToDoRequest")
    @ResponsePayload
    public ModificarToDoResponse ModificarToDo(@RequestPayload ModificarToDoRequest peticion) {
        ModificarToDoResponse respuesta = new ModificarToDoResponse();

        Integer id = peticion.getId();
        String status = peticion.getStatus();

        Optional<ToDo> oToDo = iToDo.findById(id);
        if(oToDo.isPresent()) {
            ToDo todo;
            todo = oToDo.get();
            todo.setStatus(status);
            iToDo.save(todo);
            respuesta.setRespuesta(true);
        } else {
            respuesta.setRespuesta(false);
        }

        return respuesta;
    }
}
