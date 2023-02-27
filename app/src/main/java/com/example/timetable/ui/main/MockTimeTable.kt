package com.example.timetable.ui.main

import com.example.timetable.model.source.DailyTables
import com.example.timetable.model.source.Subject

object MockTimeTable {
    val timetable = listOf(
        DailyTables(
            week = "月",
            subjects = mapOf(
                1 to Subject(subjectName = "プロジェクト・マネージメント", classRoom = null, teacher = null, subjectColor = ""),
                2 to Subject(subjectName = "解析", classRoom = null, teacher = null, subjectColor = ""),
                3 to Subject(subjectName = "線形代数", classRoom = null, teacher = null, subjectColor = ""),
                4 to Subject(subjectName = "プロジェクト学習", classRoom = null, teacher = null, subjectColor = ""),
                5 to Subject(subjectName = "プロジェクト学習", classRoom = null, teacher = null, subjectColor = ""),
            ),
        ),
        DailyTables(
            week = "火",
            subjects = mapOf(
                1 to Subject(subjectName = "コンピューターと教育", classRoom = null, teacher = null, subjectColor = ""),
                2 to null,
                3 to Subject(subjectName = "余暇と健康I", classRoom = null, teacher = null, subjectColor = ""),
                4 to null,
                5 to null,
            ),
        ),
        DailyTables(
            week = "水",
            subjects = mapOf(
                1 to null,
                2 to Subject(subjectName = "ITアーキテクチャ", classRoom = null, teacher = null, subjectColor = ""),
                3 to null,
                4 to Subject(subjectName = "プロジェクト学習", classRoom = null, teacher = null, subjectColor = ""),
                5 to Subject(subjectName = "プロジェクト学習", classRoom = null, teacher = null, subjectColor = ""),
            ),
        ),
        DailyTables(
            week = "木",
            subjects = mapOf(
                1 to Subject(subjectName = "応用数学I", classRoom = null, teacher = null, subjectColor = ""),
                2 to Subject(subjectName = "ICTデザイン通論", classRoom = null, teacher = null, subjectColor = ""),
                3 to null,
                4 to null,
                5 to null,
            ),
        ),
        DailyTables(
            week = "金",
            subjects = mapOf(
                1 to Subject(subjectName = "解析", classRoom = null, teacher = null, subjectColor = ""),
                2 to null,
                3 to Subject(subjectName = "課外研究", classRoom = null, teacher = null, subjectColor = ""),
                4 to Subject(subjectName = "課外研究", classRoom = null, teacher = null, subjectColor = ""),
                5 to null,
            ),
        ),
    )
}
