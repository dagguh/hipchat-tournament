package pl.dagguh.tournaments.tournament

import com.fasterxml.jackson.annotation.JsonProperty
import pl.dagguh.tournaments.channel.ChannelAuthorizationDto

data class TournamentStartDto(
        @JsonProperty("id") val id: Long,
        @JsonProperty("channel") val channel: ChannelAuthorizationDto
)
