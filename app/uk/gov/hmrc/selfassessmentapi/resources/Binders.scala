/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.selfassessmentapi.resources

import play.api.mvc.PathBindable
import uk.gov.hmrc.domain.Nino
import uk.gov.hmrc.selfassessmentapi.config.AppContext
import uk.gov.hmrc.selfassessmentapi.models.SourceType.SourceType
import uk.gov.hmrc.selfassessmentapi.models.properties.PropertyType
import uk.gov.hmrc.selfassessmentapi.models.properties.PropertyType.PropertyType
import uk.gov.hmrc.selfassessmentapi.models.{SourceType, TaxYear}

object Binders {

  implicit def ninoBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[Nino] {

    def unbind(key: String, nino: Nino): String = stringBinder.unbind(key, nino.value)

    def bind(key: String, value: String): Either[String, Nino] = {
      Nino.isValid(value) match {
        case true => Right(Nino(value))
        case false => Left("ERROR_NINO_INVALID")
      }
    }
  }

  implicit def taxYearBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[TaxYear] {

    def unbind(key: String, taxYear: TaxYear): String = stringBinder.unbind(key, taxYear.value)

    def bind(key: String, value: String): Either[String, TaxYear] = {
      TaxYear.createTaxYear(value) match {
        case Some(taxYear) => Right(taxYear)
        case None => Left("ERROR_TAX_YEAR_INVALID")
      }
    }
  }

  implicit def sourceTypeBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[SourceType] {

    def unbind(key: String, `type`: SourceType): String = `type`.toString

    def bind(key: String, value: String): Either[String, SourceType] = {
      SourceType.values.find(sourceType =>  value.equals(sourceType.toString)) match {
        case Some(v) => Right(v)
        case None => Left("ERROR_INVALID_SOURCE_TYPE")
      }
    }
  }

  implicit def propertyTypeBinder(implicit stringBinder: PathBindable[String]) = new PathBindable[PropertyType] {

    override def unbind(key: String, value: PropertyType): String = value.toString

    override def bind(key: String, value: String): Either[String, PropertyType] = {
      PropertyType.values.find(propType => value.equals(propType.toString)) match {
        case Some(v) => Right(v)
        case None => Left("ERROR_INVALID_PROPERTY_TYPE")
      }
    }

  }
}
