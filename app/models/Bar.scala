package models

import org.squeryl.KeyedEntity
import org.squeryl.Schema



case class Bar(name: Option[String]) extends KeyedEntity[Long] {
  val id: Long = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("bar")
}