package ru.opencode.practice.booking.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDataWrapper {
    List<ContactData> contactDataList = new ArrayList<>();
    List<String> passengerIdList = new ArrayList<>();
    List<String> passengerNameList = new ArrayList<>();
}
