package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/api/roomdto/test1")
    public RoomDTO testRoomDTO() {
        return RoomDTO.RoomDTOBuilder.aRoomDTO()
                .withRoomId(1)
                .withRating(3)
                .withPricePerDay(70)
                .withPhotoLink("http://static.e-aranzacje.pl/e-projektanci/realizations/4340/big_047d7ba7b4f71ba9bb2d758d9e142657cd9f1187.jpg")
                .build();
    }

    @GetMapping("/api/room/test1")
    public Room testRoom() {
        return Room.RoomBuilder.aRoom()
                .withId(1)
                .withCapacity(2)
                .withDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sed odio a sapien vehicula eleifend at vel lacus. Morbi at turpis eu enim interdum ornare. Aliquam malesuada lacinia mi in accumsan. Proin eget enim elit. Phasellus tincidunt vehicula aliquet. Donec eu consectetur neque. Mauris at mollis eros. Nulla laoreet commodo ante. Integer elementum dignissim risus, in pulvinar risus aliquam quis. Donec volutpat at nisi sit amet tincidunt. Aenean eros risus, dignissim quis placerat et, dapibus vehicula erat. Vivamus non mollis mauris.\n" +
                        "\n" +
                        "Nullam sed dui feugiat mi auctor consequat. Vestibulum fringilla diam ex, quis auctor velit tincidunt suscipit. Fusce id dignissim nulla. Phasellus consequat bibendum mi a commodo. Aenean vulputate dolor id semper semper. Phasellus blandit, erat non ullamcorper rutrum, risus orci tincidunt magna, quis faucibus nulla dui id lectus. Suspendisse potenti. Phasellus mauris lacus, lobortis sit amet tellus quis, congue bibendum velit. Sed tristique, nisl quis auctor dictum, eros est scelerisque nisl, eu tincidunt libero tellus eget lectus. Vestibulum maximus sapien arcu, vel commodo quam eleifend at. Donec maximus augue velit, non auctor purus blandit id. Fusce neque erat, venenatis ac felis sodales, imperdiet aliquet risus. Nam vel nunc vitae ex mattis cursus. Cras vel finibus libero.\n" +
                        "\n")
                .withPetFriendly(true)
                .withPhotoLink("http://static.e-aranzacje.pl/e-projektanci/realizations/4340/big_047d7ba7b4f71ba9bb2d758d9e142657cd9f1187.jpg")
                .withPricePerDay(70)
                .withRating(3)
                .withRoomNumber("213a")
                .build();
    }

    @GetMapping("/api/room/number/{roomNumber}")
    public Room findByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        return roomService.findByRoomNumber(roomNumber);
    }

    @GetMapping("/api/room/id/{Id}")
    public Room findById(@PathVariable("Id") long Id) {
        return roomService.findById(Id);
    }

    @GetMapping("/api/room/all")
    public List<Room> findAllRooms() {
        return roomService.findAll();
    }

    @DeleteMapping("/api/room/{Id}")
    public Room deleteRoomId(@PathVariable("Id") long Id) {
        return roomService.deleteRoomById(Id);
    }

    @PostMapping("/api/room/{Id}")
    public Room updateRoomId(@PathVariable("Id") long Id, @RequestBody Room room) {
        return roomService.updateRoomById(Id, room);
    }

    @PostMapping("api/room/add")
    public Room addRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.addRoom(roomDTO);
    }
}
