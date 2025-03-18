package com.example.clean_architecture_android.core.common
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.example.clean_architecture_android.domain.model.ProductItem

@Composable
fun RatingBar(
    rating: Double,
    modifier: Modifier = Modifier,
    starSize: Dp = 16.dp,
    spaceBetween: Dp = 2.dp,
    activeColor: Color = Color(0xFFFFC107),
    inactiveColor: Color = Color.LightGray
) {
    Row(modifier = modifier) {
        val fullStars = rating.toInt()
        val hasHalfStar = (rating - fullStars) >= 0.5
        val emptyStars = 5 - fullStars - if (hasHalfStar) 1 else 0

        repeat(fullStars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Full Star",
                tint = activeColor,
                modifier = Modifier.size(starSize)
            )
            Spacer(modifier = Modifier.width(spaceBetween))
        }
        if (hasHalfStar) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Half Star",
                tint = activeColor,
                modifier = Modifier.size(starSize)
            )
            Spacer(modifier = Modifier.width(spaceBetween))
        }
        repeat(emptyStars) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Empty Star",
                tint = inactiveColor,
                modifier = Modifier.size(starSize)
            )
            if (index != emptyStars - 1) {
                Spacer(modifier = Modifier.width(spaceBetween))
            }
        }
    }
}

// Updated ProductCard with RatingBar below title
@Composable
fun ProductCard(
    product: ProductItem,
    onProductClick: () -> Unit,
    onCartClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)), // Light gray background
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onProductClick() }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .aspectRatio(1f)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(product.thumbnail),
                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )
                }
            }
            // Details Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.White.copy(alpha = 0.2f))
            ) {
                // Title and Rating
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = product.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        maxLines = 1
                    )
                    RatingBar(
                        rating = product.rating,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "(${product.rating})",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = product.category,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        maxLines = 1,
                        color = Color.Gray
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${product.price}",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    IconButton(onClick = onCartClick) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Add to Cart",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}
