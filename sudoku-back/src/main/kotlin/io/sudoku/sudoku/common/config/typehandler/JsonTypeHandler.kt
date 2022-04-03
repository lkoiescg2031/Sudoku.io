package io.sudoku.sudoku.common.config.typehandler

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.TypeHandler
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

open class JsonTypeHandler<T>(private val clazz: Class<T>) : TypeHandler<T> {
    override fun setParameter(ps: PreparedStatement?, i: Int, parameter: T, jdbcType: JdbcType?) {
        val objectMapper = ObjectMapper()
        val jsonStr = objectMapper.writeValueAsString(parameter)
        ps?.setString(i, jsonStr)
    }

    override fun getResult(rs: ResultSet?, columnName: String?): T {
        val objectMapper = ObjectMapper()
        val jsonStr = rs?.getString(columnName)
        return objectMapper.readValue(jsonStr, clazz)
    }

    override fun getResult(rs: ResultSet?, columnIndex: Int): T {
        val objectMapper = ObjectMapper()
        val jsonStr = rs?.getString(columnIndex)
        return objectMapper.readValue(jsonStr, clazz)
    }

    override fun getResult(cs: CallableStatement?, columnIndex: Int): T {
        val objectMapper = ObjectMapper()
        val jsonStr = cs?.getString(columnIndex)
        return objectMapper.readValue(jsonStr, clazz)
    }
}