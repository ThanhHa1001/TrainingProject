package repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.StudentEntity;
import repository.IGenericRepository;
import util.DatetimeUtils;

public class StudentRepository extends BaseRepository implements IGenericRepository<StudentEntity, Long> {
	private static Logger logger = LoggerFactory.getLogger(StudentRepository.class);

	@Override
	public List<StudentEntity> findAll() {
		List<StudentEntity> students = new ArrayList<>();

		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT s.*, ");
			builder.append("c.id, c.name as c_name, ");
			builder.append("m.id, CONCAT(m.first_name, ' ', m.last_name) as m_name ");
			builder.append("FROM Student s ");
			builder.append("INNER JOIN Classroom c ON c.id = s.classroom_id ");
			builder.append("INNER JOIN Ministry m ON m.id = c.ministry_id ");
			rs = stmt.executeQuery(builder.toString());

			StudentEntity student = null;
			while (rs.next()) {
				student = new StudentEntity();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setNote(rs.getString("note"));
				student.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				student.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				student.setModifiedAt(dateModifiedAt);

				student.setModifiedBy(rs.getString("modified_by"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setClassroomName(rs.getString("c_name"));
				student.setMinistryName(rs.getString("m_name"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findAll() method", e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findAll() method - finally", e);
			}
		}

		return students;
	}

	@Override
	public StudentEntity findById(Long value) {
		StudentEntity student = new StudentEntity();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT s.*, ");
			builder.append("c.id, c.name as c_name, ");
			builder.append("m.id, CONCAT(m.first_name, ' ', m.last_name) as m_name ");
			builder.append("FROM Student s ");
			builder.append("INNER JOIN Classroom c ON c.id = s.classroom_id ");
			builder.append("INNER JOIN Ministry m ON m.id = c.ministry_id ");
			builder.append("WHERE s.id = ? ");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setNote(rs.getString("note"));
				student.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				student.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				student.setModifiedAt(dateModifiedAt);

				student.setModifiedBy(rs.getString("modified_by"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setClassroomName(rs.getString("c_name"));
				student.setMinistryName(rs.getString("m_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findById() method ", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findById() method - finally ", e); 
			}
		}

		return student;
	}

	@Override
	public int insert(StudentEntity entity) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(
					"INSERT INTO Student (first_name, last_name, classroom_id, note, created_at, created_by) ");
			builder.append("VALUES (?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setLong(3, entity.getClassroomId());
			pstmt.setString(4, entity.getNote());
			pstmt.setString(5, DatetimeUtils.convertDateToString(entity.getCreatedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(6,  entity.getCreatedBy());

			rowAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("insert() method ", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("insert() method - finnaly", e);
			}
		}

		return rowAffected;
	}

	@Override
	public int update(StudentEntity entity) {
		Connection conn = getConnection();;
		PreparedStatement pstmt = null;
		int rowAffected = -1;

		try {
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE Student SET ");
			builder.append("first_name = ?, ");  // 1
			builder.append("last_name = ?, ");  // 2
			builder.append("classroom_id = ?, "); // 3
			builder.append("note = ?, ");  // 4
			builder.append("modified_at = ?, "); // 5
			builder.append("modified_by = ? ");  // 6
			builder.append("WHERE id = ? "); // 7

			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, entity.getFirstName());
			pstmt.setString(2, entity.getLastName());
			pstmt.setLong(3, entity.getClassroomId());
			pstmt.setString(4, entity.getNote());
			pstmt.setString(5,
					DatetimeUtils.convertDateToString(entity.getModifiedAt(), DatetimeUtils.CREATED_AT_PATTERN));
			pstmt.setString(6, entity.getModifiedBy());
			pstmt.setLong(7, entity.getId());

			rowAffected = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("update() method");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("update() method - finnaly", e);
			}
		}

		return rowAffected;
	}

	@Override
	public int delete(Long value) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int rowAffected = -1;
		
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("DELETE FROM Student ");
			builder.append("WHERE id = ? ");
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rowAffected = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("delete() method");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("delete() method - finnaly", e);
			}
		}

		return rowAffected;
	}
	
	public List<StudentEntity> findByMinistryId(Long value) {
		List<StudentEntity> students = new ArrayList<>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT s.*, ");
			builder.append("c.id, c.name as c_name, ");
			builder.append("m.id, CONCAT(m.first_name, ' ', m.last_name) as m_name ");
			builder.append("FROM Student s ");
			builder.append("INNER JOIN Classroom c ON c.id = s.classroom_id ");
			builder.append("INNER JOIN Ministry m ON m.id = c.ministry_id ");
			builder.append("WHERE m.id = ? ");
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1, value);
			rs = pstmt.executeQuery();

			StudentEntity student = null;
			while (rs.next()) {
				student = new StudentEntity();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setNote(rs.getString("note"));
				student.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				student.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				student.setModifiedAt(dateModifiedAt);

				student.setModifiedBy(rs.getString("modified_by"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setClassroomName(rs.getString("c_name"));
				student.setMinistryName(rs.getString("m_name"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findAll() method", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findAll() method - finally", e);
			}
		}

		return students;
	}
	
	public List<StudentEntity> findByNameOrClass(String nameOrClass) {
		List<StudentEntity> students = new ArrayList<>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT s.*, ");
			builder.append("c.id, c.name as c_name, ");
			builder.append("m.id, CONCAT(m.first_name, ' ', m.last_name) as m_name ");
			builder.append("FROM Student s ");
			builder.append("INNER JOIN Classroom c ON c.id = s.classroom_id ");
			builder.append("INNER JOIN Ministry m ON m.id = c.ministry_id ");
			builder.append("WHERE s.last_name LIKE '%' ? '%' or c.name LIKE '%' ? '%' ");
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, nameOrClass);
			pstmt.setString(2, nameOrClass);
			rs = pstmt.executeQuery();

			StudentEntity student = null;
			while (rs.next()) {
				student = new StudentEntity();
				student.setId(rs.getLong("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setNote(rs.getString("note"));
				student.setCreatedAt(DatetimeUtils.convertDateToString(rs.getString("created_at"),
						DatetimeUtils.CREATED_AT_PATTERN));
				student.setCreatedBy(rs.getString("created_by"));

				Date dateModifiedAt = null;
				if (rs.getString("modified_at") != null) {
					dateModifiedAt = DatetimeUtils.convertDateToString(rs.getString("modified_at"),
							DatetimeUtils.CREATED_AT_PATTERN);
				}
				student.setModifiedAt(dateModifiedAt);

				student.setModifiedBy(rs.getString("modified_by"));
				student.setClassroomId(rs.getLong("classroom_id"));
				student.setClassroomName(rs.getString("c_name"));
				student.setMinistryName(rs.getString("m_name"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("findAll() method", e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("findAll() method - finally", e);
			}
		}

		return students;
	}
}