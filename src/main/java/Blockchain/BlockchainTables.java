/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Blockchain;

/**
 *
 * @author putubgs
 */
import java.util.HashMap;
import java.util.Map;

public class BlockchainTables {
    private static BlockchainTables instance;
    private static Blockchain userInformationBlockchain;
    private static Blockchain digitalCertificateBlockchain;
    private static Blockchain courseEnrollmentBlockchain;
    private static Blockchain courseCompletionRecordBlockchain;
    private static Blockchain transactionRecordBlockchain;
    private static Blockchain adminRecordBlockchain;

    private BlockchainTables() {
        userInformationBlockchain = Blockchain.getInstance("user_information.bin");
        digitalCertificateBlockchain = Blockchain.getInstance("digital_certificate.bin");
        courseEnrollmentBlockchain = Blockchain.getInstance("course_enrollment.bin");
        courseCompletionRecordBlockchain = Blockchain.getInstance("course_completion_record.bin");
        transactionRecordBlockchain = Blockchain.getInstance("transaction_record.bin");
        adminRecordBlockchain = Blockchain.getInstance("admin_record.bin");
    }

    public static BlockchainTables getInstance() {
        if (instance == null) {
            instance = new BlockchainTables();
        }
        return instance;
    }

    public enum Table {
        USER_INFORMATION, DIGITAL_CERTIFICATE, COURSE_ENROLLMENT, COURSE_COMPLETION_RECORD, TRANSACTION_RECORD, ADMIN_RECORD;
    }

    public void addData(Table table, String data) {
        switch (table) {
            case USER_INFORMATION:
                userInformationBlockchain.addData(data);
                break;
            case DIGITAL_CERTIFICATE:
                digitalCertificateBlockchain.addData(data);
                break;
            case COURSE_ENROLLMENT:
                courseEnrollmentBlockchain.addData(data);
                break;
            case COURSE_COMPLETION_RECORD:
                courseCompletionRecordBlockchain.addData(data);
                break;
            case TRANSACTION_RECORD:
                transactionRecordBlockchain.addData(data);
                break;
            case ADMIN_RECORD:
                adminRecordBlockchain.addData(data);
                break;
        }
    }

    public void printTable(Table table) {
        switch (table) {
            case USER_INFORMATION:
                System.out.println(userInformationBlockchain.getAllData());
                break;
            case DIGITAL_CERTIFICATE:
                System.out.println(digitalCertificateBlockchain.getAllData());
                break;
            case COURSE_ENROLLMENT:
                System.out.println(courseEnrollmentBlockchain.getAllData());
                break;
            case COURSE_COMPLETION_RECORD:
                System.out.println(courseCompletionRecordBlockchain.getAllData());
                break;
            case TRANSACTION_RECORD:
                System.out.println(transactionRecordBlockchain.getAllData());
                break;
            case ADMIN_RECORD:
                System.out.println(adminRecordBlockchain.getAllData());
                break;
        }
    }
}

