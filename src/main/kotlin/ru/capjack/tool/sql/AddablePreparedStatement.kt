package ru.capjack.tool.sql

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.*
import java.sql.Array
import java.sql.Date
import java.util.*


interface AddablePreparedStatement : PreparedStatement {
	
	/**
	 * @see PreparedStatement.setNull
	 */
	@Throws(SQLException::class)
	fun addNull(sqlType: Int)
	
	/**
	 * @see PreparedStatement.setBoolean
	 */
	@Throws(SQLException::class)
	fun addBoolean(x: Boolean)
	
	/**
	 * @see PreparedStatement.setByte
	 */
	@Throws(SQLException::class)
	fun addByte(x: Byte)
	
	/**
	 * @see PreparedStatement.setShort
	 */
	@Throws(SQLException::class)
	fun addShort(x: Short)
	
	/**
	 * @see PreparedStatement.setInt
	 */
	@Throws(SQLException::class)
	fun addInt(x: Int)
	
	/**
	 * @see PreparedStatement.setLong
	 */
	@Throws(SQLException::class)
	fun addLong(x: Long)
	
	/**
	 * @see PreparedStatement.setFloat
	 */
	@Throws(SQLException::class)
	fun addFloat(x: Float)
	
	/**
	 * @see PreparedStatement.setDouble
	 */
	@Throws(SQLException::class)
	fun addDouble(x: Double)
	
	/**
	 * @see PreparedStatement.setBigDecimal
	 */
	@Throws(SQLException::class)
	fun addBigDecimal(x: BigDecimal)
	
	/**
	 * @see PreparedStatement.setString
	 */
	@Throws(SQLException::class)
	fun addString(x: String)
	
	/**
	 * @see PreparedStatement.setBytes
	 */
	@Throws(SQLException::class)
	fun addBytes(x: ByteArray)
	
	/**
	 * @see PreparedStatement.setDate
	 */
	@Throws(SQLException::class)
	fun addDate(x: Date)
	
	/**
	 * @see PreparedStatement.setTime
	 */
	@Throws(SQLException::class)
	fun addTime(x: Time)
	
	/**
	 * @see PreparedStatement.setTimestamp
	 */
	@Throws(SQLException::class)
	fun addTimestamp(x: Timestamp)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	@Throws(SQLException::class)
	fun addAsciiStream(x: InputStream, length: Int)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	@Throws(SQLException::class)
	fun addBinaryStream(x: InputStream, length: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	@Throws(SQLException::class)
	fun addObject(x: Any, targetSqlType: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	@Throws(SQLException::class)
	fun addObject(x: Any)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	@Throws(SQLException::class)
	fun addCharacterStream(reader: Reader, length: Int)
	
	/**
	 * @see PreparedStatement.setRef
	 */
	@Throws(SQLException::class)
	fun addRef(x: Ref)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	@Throws(SQLException::class)
	fun addBlob(x: Blob)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	@Throws(SQLException::class)
	fun addClob(x: Clob)
	
	/**
	 * @see PreparedStatement.setArray
	 */
	@Throws(SQLException::class)
	fun addArray(x: Array)
	
	/**
	 * @see PreparedStatement.setDate
	 */
	@Throws(SQLException::class)
	fun addDate(x: Date, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setTime
	 */
	@Throws(SQLException::class)
	fun addTime(x: Time, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setTimestamp
	 */
	@Throws(SQLException::class)
	fun addTimestamp(x: Timestamp, cal: Calendar)
	
	/**
	 * @see PreparedStatement.setNull
	 */
	@Throws(SQLException::class)
	fun addNull(sqlType: Int, typeName: String)
	
	/**
	 * @see PreparedStatement.setURL
	 */
	@Throws(SQLException::class)
	fun addURL(x: URL)
	
	/**
	 * @see PreparedStatement.setRowId
	 */
	@Throws(SQLException::class)
	fun addRowId(x: RowId)
	
	/**
	 * @see PreparedStatement.setNString
	 */
	@Throws(SQLException::class)
	fun addNString(value: String)
	
	/**
	 * @see PreparedStatement.setNCharacterStream
	 */
	@Throws(SQLException::class)
	fun addNCharacterStream(value: Reader, length: Long)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	@Throws(SQLException::class)
	fun addNClob(value: NClob)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	@Throws(SQLException::class)
	fun addClob(reader: Reader, length: Long)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	@Throws(SQLException::class)
	fun addBlob(inputStream: InputStream, length: Long)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	@Throws(SQLException::class)
	fun addNClob(reader: Reader, length: Long)
	
	/**
	 * @see PreparedStatement.setSQLXML
	 */
	@Throws(SQLException::class)
	fun addSQLXML(xmlObject: SQLXML)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	@Throws(SQLException::class)
	fun addObject(x: Any, targetSqlType: Int, scaleOrLength: Int)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	@Throws(SQLException::class)
	fun addAsciiStream(x: InputStream, length: Long)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	@Throws(SQLException::class)
	fun addBinaryStream(x: InputStream, length: Long)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	@Throws(SQLException::class)
	fun addCharacterStream(reader: Reader, length: Long)
	
	/**
	 * @see PreparedStatement.setAsciiStream
	 */
	@Throws(SQLException::class)
	fun addAsciiStream(x: InputStream)
	
	/**
	 * @see PreparedStatement.setBinaryStream
	 */
	@Throws(SQLException::class)
	fun addBinaryStream(x: InputStream)
	
	/**
	 * @see PreparedStatement.setCharacterStream
	 */
	@Throws(SQLException::class)
	fun addCharacterStream(reader: Reader)
	
	/**
	 * @see PreparedStatement.setNCharacterStream
	 */
	@Throws(SQLException::class)
	fun addNCharacterStream(value: Reader)
	
	/**
	 * @see PreparedStatement.setClob
	 */
	@Throws(SQLException::class)
	fun addClob(reader: Reader)
	
	/**
	 * @see PreparedStatement.setBlob
	 */
	@Throws(SQLException::class)
	fun addBlob(inputStream: InputStream)
	
	/**
	 * @see PreparedStatement.setNClob
	 */
	@Throws(SQLException::class)
	fun addNClob(reader: Reader)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	@Throws(SQLException::class)
	fun addObject(x: Any, targetSqlType: SQLType, scaleOrLength: Int)
	
	/**
	 * @see PreparedStatement.setObject
	 */
	@Throws(SQLException::class)
	fun addObject(x: Any, targetSqlType: SQLType)
	
	companion object {
		fun wrap(statement: PreparedStatement): AddablePreparedStatement {
			return AddablePreparedStatementImpl(statement)
		}
	}
}
