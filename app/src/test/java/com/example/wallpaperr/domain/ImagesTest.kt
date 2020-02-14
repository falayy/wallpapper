package com.example.wallpaperr.domain

import com.google.common.truth.Truth
import org.junit.Test

class ImagesTest{

    lateinit var expectedImagesModel: Images

    @Test
     fun isImageModel(){
        //Given
        expectedImagesModel = Images(
            id = 1,
            fullImage = "image.com",
            previewImageUrl = "image.com/preview"
        )
        val actualImageModel = expectedImagesModel.copy()


        //Then
        Truth.assertThat(expectedImagesModel).isInstanceOf(Images::class.java)
        Truth.assertThat(actualImageModel).isInstanceOf(Images::class.java)

     }
}