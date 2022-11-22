package com.example.mytello;


import com.google.common.base.Predicate;
import org.python.util.PythonInterpreter;

public class Main implements Predicate<PythonInterpreter> {
    @Override
    public boolean apply(PythonInterpreter anInterpreter) {

        /*
         * Examples of creating and initializing variables in the monkeyrunner environment's
         * namespace. During execution, the monkeyrunner program can refer to the variables "newtest"
         * and "use_emulator"
         *
         */
        anInterpreter.set("newtest", "enabled");
        anInterpreter.set("use_emulator", 1);

        return true;
    }
}