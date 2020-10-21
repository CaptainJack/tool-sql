package ru.capjack.tool.sql

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.*
import java.sql.Array
import java.sql.Date
import java.time.LocalDateTime
import java.util.*


interface AddablePreparedStatement : PreparedStatement {
	fun nextIndex(): Int
	
	fun resetIndex()
	
	fun addLocalDateTime(x: LocalDateTime?)
	
	fun addEnum(x: Enum<*>?)
	
	/**
	 * @see PreparedStatement.setNull
	 */
	fun addNull(sqlType: Int)
	
	/**
	 * @see PreparedStatement.setBoolean
	 */
	fun addBoolean(x: Boolean)
	
	/**
	 * @see PreparedStatement.setByte
	 */
	fun addByte(x: Byte)
	
	/**
	 * @see PreparedStatement.setShort
	 */
	fun addShort(x: Short)
	
	/**
	 * @see PreparedStatement.setInt
	 */
	fun addInt(x: Int)
	
	/**
	 * @see PreparedStatement.setLong
	 */
	fun addLong(x: Long)
	
	/**
	 * @see PreparedStatement.setFloat
	 */
	fun addFloat(x: Float)
	
	/**
	 * @see PreparedStatement.setDouble
	 */
	fun addDouble(x: Double)
	
	/**
	 * @see PreparedStatement.setBigDecimal
	 */
	fun addBigDecimal(x: BigDecimal?)
	
	/**
	 * @see PreparedStatement.setString
	 */
	fun addString(x: String?)
	
	/**
	 * @see PreparedStatement.setBytes
	 */
	fun addBytes(x: ByteArray?)
	
	/**
	 * @see PreparedStatement.setDate
	 */
	fun addDate(x: Date?)
	
	/**
	 * @see PreparedStatement.setTime
	 */
	fun addTime(x: Time?)
	
	/**
	 * @see PreparedStatement.setTimestamp
	 */
	fun addTimestamp(x: Timestamp?)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	fun addAsciiStream(x: InputStream?, length: Int)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	fun addBinaryStream(x: InputStream?, length: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	fun addObject(x: Any?, targetSqlType: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	fun addObject(x: Any?)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	fun addCharacterStream(reader: Reader?, length: Int)
	
	/**
	 * @see PreparedStatement.setRef
	 */
	fun addRef(x: Ref?)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	fun addBlob(x: Blob?)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	fun addClob(x: Clob?)
	
	/**
	 * @see PreparedStatement.setArray
	 */
	fun addArray(x: Array?)
	
	/**
	 * @see PreparedStatement.setDate
	 */
	fun addDate(x: Date?, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setTime
	 */
	fun addTime(x: Time?, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setTimestamp
	 */
	fun addTimestamp(x: Timestamp?, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setNull
	 */
	fun addNull(sqlType: Int, typeName: String)
	
	/**
	 * @see PreparedStatement.setURL
	 */
	fun addURL(x: URL?)
	
	/**
	 * @see PreparedStatement.setRowId
	 */
	fun addRowId(x: RowId?)
	
	/**
	 * @see PreparedStatement.setNString
	 */
	fun addNString(value: String?)
	
	/**
	 * @see PreparedStatement.setNCharacterStream
	 */
	fun addNCharacterStream(value: Reader?, length: Long)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	fun addNClob(value: NClob?)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	fun addClob(reader: Reader?, length: Long)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	fun addBlob(inputStream: InputStream?, length: Long)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	fun addNClob(reader: Reader?, length: Long)
	
	/**
	 * @see PreparedStatement.setSQLXML
	 */
	fun addSQLXML(xmlObject: SQLXML?)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	fun addObject(x: Any?, targetSqlType: Int, scaleOrLength: Int)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	fun addAsciiStream(x: InputStream?, length: Long)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	fun addBinaryStream(x: InputStream?, length: Long)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	fun addCharacterStream(reader: Reader?, length: Long)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	fun addAsciiStream(x: InputStream?)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	fun addBinaryStream(x: InputStream?)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	fun addCharacterStream(reader: Reader?)
	
	/**
	 * @see PreparedStatement.setNCharacterStream
	 */
	fun addNCharacterStream(value: Reader?)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	fun addClob(reader: Reader?)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	fun addBlob(inputStream: InputStream?)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	fun addNClob(reader: Reader?)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	fun addObject(x: Any?, targetSqlType: SQLType, scaleOrLength: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	fun addObject(x: Any?, targetSqlType: SQLType)
}
