package com.lwch.survey.utils;

import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineFactory {

    public static Compilable getScriptEngine() {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        return (Compilable)engine;
    }

}