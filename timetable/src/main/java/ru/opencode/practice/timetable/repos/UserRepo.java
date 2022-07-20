package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.practice.timetable.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
}
