package com.elle.analyster;

import com.elle.analyster.presentation.filter.DistinctColumnItem;
import com.elle.analyster.presentation.filter.ITableFilter;
import com.elle.analyster.presentation.filter.TableRowFilterSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

import static com.elle.analyster.service.Connection.connection;

/**
 * User: danielabecker
 */
public class LoadTables {

    private Analyster ana =Analyster.getInstance();
    JLabel numOfRecords1 = ana.getNumOfRecords1();
    JLabel numOfRecords2 = ana.getNumOfRecords2();
    JTable assignmentTable = ana.getassignmentTable();
    JTable reportTable = ana.getReportTable();
    JTable archiveAssignTable = ana.getArchiveAssignTable();
//    JTable viewerTable = ana.getViewerTable();
    Logger log = LoggerFactory.getLogger(LoadTables.class);

    public void loadTables() {
        loadAssignmentTable();
        ana.setTerminalsFunction(ana.getassignmentTable());

        loadReportTable();
        ana.setTerminalsFunction(ana.getReportTable());


        loadArchiveAssignTable();
        ana.setTerminalsFunction(ana.getArchiveAssignTable());

//        loadViewerTable();
        ana.setLastUpdateTime();
    }

    public void loadAssignmentTable() {

        try {
            connection(ana.sqlQuery(Analyster.getAssignmentsTableName()), assignmentTable);
        } catch (SQLException e) {
            log.error("Error", e);
        }
        ana.setColumnFormat(ana.columnWidthPercentage1, assignmentTable);
        ana.getAssignments().init(assignmentTable, new String[]{"Symbol", "Analyst"});
        ana.setFilterTempAssignment(TableRowFilterSupport.forTable(assignmentTable).actions(true).apply());
        ana.getFilterTempAssignment().getTable();   // create filter when the table is loaded.
        Analyster.setNumberAssignmentInit(assignmentTable.getRowCount());
        ana.getjActivateRecord().setEnabled(false);
        ana.getjArchiveRecord().setEnabled(true);

        numOfRecords1.setText("Number of records in Assignments: " + assignmentTable.getRowCount());
        numOfRecords2.setText("Number of records shown: " + assignmentTable.getRowCount());

    }

    public void loadAssignmentTableWithFilter(int columnIndex, Collection<DistinctColumnItem> filterCriteria) {

        try {
            connection(ana.sqlQuery(Analyster.getAssignmentsTableName()), assignmentTable);
        } catch (SQLException e) {
            log.error("Error", e);
        }
        ana.setColumnFormat(ana.columnWidthPercentage1, assignmentTable);
        ana.getAssignments().init(assignmentTable, new String[]{"Symbol", "Analyst"});
        ITableFilter<?> filter = TableRowFilterSupport
                                        .forTable(assignmentTable)
                                        .actions(true)
                                        .apply();
        ana.setFilterTempAssignment(filter);
        ana.getFilterTempAssignment().getTable();   // create filter when the table is loaded.
        Analyster.setNumberAssignmentInit(assignmentTable.getRowCount());
        ana.getjActivateRecord().setEnabled(false);
        ana.getjArchiveRecord().setEnabled(true);

        numOfRecords1.setText("Number of records in Assignments: " + assignmentTable.getRowCount());
        numOfRecords2.setText("Number of records shown: " + assignmentTable.getRowCount());

        filter.apply(columnIndex, filterCriteria);
        filter.saveTableState();
        filter.saveFilterCriteria(filterCriteria);
        filter.setColumnIndex(columnIndex);

    }

    public void loadArchiveAssignTable() {

        try {
            connection(ana.sqlQuery(Analyster.getArchiveTableName()), archiveAssignTable);
        } catch (SQLException e) {
            log.error("Error", e);
        }
        ana.setColumnFormat(ana.columnWidthPercentage1, archiveAssignTable);
        ana.getArchiveAssign().init(archiveAssignTable, new String[]{"Symbol", "Analyst"});
        ana.setTerminalsFunction(archiveAssignTable);
        Analyster.setNumberArchiveAssignInit(archiveAssignTable.getRowCount());
    }
    public void loadArchiveTableWithFilter(int columnIndex, Collection<DistinctColumnItem> filterCriteria) {

        try {
            connection(ana.sqlQuery(Analyster.getArchiveTableName()), archiveAssignTable);
        } catch (SQLException e) {
            log.error("Error", e);
        }
        ana.setColumnFormat(ana.columnWidthPercentage1, archiveAssignTable);
        ana.getAssignments().init(archiveAssignTable, new String[]{"Symbol", "Analyst"});
        ITableFilter<?> filter = TableRowFilterSupport
                .forTable(archiveAssignTable)
                .actions(true)
                .apply();
        ana.setFilterTempArchive(filter);
        ana.getFilterTempAssignment().getTable();   // create filter when the table is loaded.
        Analyster.setNumberAssignmentInit(archiveAssignTable.getRowCount());
        ana.getjActivateRecord().setEnabled(true);
        ana.getjArchiveRecord().setEnabled(false);

//        numOfRecords1.setText("Number of records in Assignments: " + assignmentTable.getRowCount());
//        numOfRecords2.setText("Number of records shown: " + assignmentTable.getRowCount());

        filter.apply(columnIndex, filterCriteria);
        filter.saveTableState();
        filter.saveFilterCriteria(filterCriteria);
        filter.setColumnIndex(columnIndex);

    }
      public void loadReportTable() {
          try {
              connection(ana.sqlQuery(Analyster.getReportsTableName()), reportTable);
          } catch (SQLException e) {
              log.error("Error", e);
          }
          ana.setColumnFormat(ana.columnWidthPercentage2, reportTable);
        ana.getReports().init(reportTable, new String[]{"Symbol", "Author"});
        Analyster.setNumberReportsInit(reportTable.getRowCount());
    }

    public void loadReportTableWithFilter(int columnIndex, Collection<DistinctColumnItem> filterCriteria) {

        try {
            connection(ana.sqlQuery(Analyster.getReportsTableName()), reportTable);
        } catch (SQLException e) {
            log.error("Error", e);
        }
        ana.setColumnFormat(ana.columnWidthPercentage2, reportTable);
        ana.getAssignments().init(reportTable, new String[]{"Symbol", "Author"});
        ITableFilter<?> filter = TableRowFilterSupport
                .forTable(reportTable)
                .actions(true)
                .apply();
        ana.setFilterTempReport(filter);
        ana.getFilterTempReport().getTable();   // create filter when the table is loaded.
        Analyster.setNumberAssignmentInit(reportTable.getRowCount());
        ana.getjActivateRecord().setEnabled(false);
        ana.getjArchiveRecord().setEnabled(true);

//        numOfRecords1.setText("Number of records in Assignments: " + assignmentTable.getRowCount());
//        numOfRecords2.setText("Number of records shown: " + assignmentTable.getRowCount());

        filter.apply(columnIndex, filterCriteria);
        filter.saveTableState();
        filter.saveFilterCriteria(filterCriteria);
        filter.setColumnIndex(columnIndex);
    }
//    public void loadViewerTable(){
//        try {
//            connection(ana.sqlQuery(Analyster.getAssignmentsTableName()), viewerTable);
//        } catch (SQLException e) {
//            log.error("Error", e);
//        }
//        ana.setColumnFormat(ana.columnWidthPercentage1, viewerTable);
//        ana.getViewer().init(viewerTable, new String[]{"Symbol", "Analyst"});
//        ana.setFilterTempAssignment(TableRowFilterSupport.forTable(viewerTable).actions(true).apply());
//        ana.getFilterTempAssignment().getTable();   // create filter when the table is loaded.
//        Analyster.setNumberAssignmentInit(viewerTable.getRowCount());
//        ana.getjActivateRecord().setEnabled(false);
//        ana.getjArchiveRecord().setEnabled(true);
//    }
  

}
