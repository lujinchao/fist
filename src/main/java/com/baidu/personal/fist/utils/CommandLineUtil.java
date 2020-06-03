package com.baidu.personal.fist.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

/**
 * @author lujinchao@baidu.com
 * @date 2020-05-13 11:31:49
 */

@Slf4j
public class CommandLineUtil {

    public static CommandLine parseCommandLine(String[] args) {
        Options options = new Options();
        Option mode = new Option("m", "mode", true, "run mode with server or client");
        mode.setRequired(true);
        options.addOption(mode);
        Option initialize = new Option("i", "initialize", false, "whether need initialize");
        options.addOption(initialize);
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException exception) {
            HelpFormatter formatter = new HelpFormatter();
            log.error(exception.getMessage());
            formatter.printHelp("args description", options);
            System.exit(1);
        }
        return commandLine;
    }

}
