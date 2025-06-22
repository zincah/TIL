package org.example.effective.chapter6.item38;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
public class OperationTest {

    @Test
    public void operationTest(){
        double x = Double.parseDouble("4");
        double y = Double.parseDouble("2");

        test(BasicOperation.class, x, y);
        test(ExtendedOperation.class, x, y);

        List<Operation> list = new ArrayList<>();
        list.addAll(Arrays.asList(BasicOperation.values()));
        list.addAll(Arrays.asList(ExtendedOperation.values()));
        test2(list, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y
    ){
        for(Operation op : opEnumType.getEnumConstants()){
            log.debug("{} {} {} = {}",
                    x, op, y, op.apply(x, y));
        }
    }

    private static void test2(Collection<? extends Operation> opSet, double x, double y){
        for(Operation op : opSet){
            log.debug("{} {} {} = {}",
                    x, op, y, op.apply(x, y));
        }
    }
}
