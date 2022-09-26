package com.justdoit.lamusic_kotlin.student.entity

import com.justdoit.lamusic_kotlin.student.dto.StudentDTO
import java.util.*

class StudentPayment(
        var cashAmount: String?= null,
        var accountAmount: String?= null,
        var cardAmount: String?= null,
        var cardCompanyInfo: String?= null,
        var paymentMemo: String?= null,
        var accountDate: Date?= null,
        var createDate: Date
) {

    companion object{
        fun createStudentPayment(req: StudentDTO.StudentReq): StudentPayment {
            return req.run {
                StudentPayment(
                        cashAmount = cashAmount,
                        accountAmount = accountAmount,
                        cardAmount = cardAmount,
                        cardCompanyInfo = cardCompanyInfo,
                        paymentMemo = paymentMemo,
                        accountDate = accountDate,
                        createDate = Date()
                )
            }
        }
    }
}