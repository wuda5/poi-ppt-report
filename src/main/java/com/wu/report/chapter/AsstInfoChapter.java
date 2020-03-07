package com.wu.report.chapter;

import com.wu.domain.User;
import com.wu.report.dataMerge.SlideData;
import lombok.Data;

import java.util.List;
@Data
public class AsstInfoChapter implements ISlidedataConverter {

    private  List<User> users;

    @Override
    public List<SlideData> generate() {
        return null;
    }
}
