package us.bowron.apps.juliet.api;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.graphics.drawable.Drawable;


/**
 * Representing photos that are supplied as part of the app
 * 
 * @author dagfinn.parnas
 *
 */
public class SlideshowPhotoDrawable extends SlideshowPhoto {
	protected int largePhotoDrawableId;
	protected Context context;
	
	public SlideshowPhotoDrawable(Context context, String title, String description, int largePhotoDrawableId, String largePhotoShareUrl){
		super(title,description,null,null,"dummy url");
		this.largePhotoDrawableId=largePhotoDrawableId;
		this.context=context;
		this.largePhoto=largePhotoShareUrl;
	}
	/* (non-Javadoc)
	 * @see com.elsewhat.smugmug.api.SlideshowPhoto#getLargePhotoDrawable(java.io.File)
	 */
	@Override
	public Drawable getLargePhotoDrawable(File folder, int maxWidth, int maxHeight)throws IOException {
		//changed this due to ICS bug causing a too large drawable
		//return context.getResources().getDrawable(largePhotoDrawableId);
		return FileUtils.readBitmapFromResources(context.getResources(), largePhotoDrawableId, maxWidth,maxHeight);
		
	}
	/* (non-Javadoc)
	 * @see com.elsewhat.smugmug.api.SlideshowPhoto#isCacheExisting(java.io.File)
	 */
	@Override
	public boolean isCacheExisting(File folder) {
		//return false in order for share photo to use largePhotoShareUrl
		return false;
	}
	
	/**
	 * Returns the drawable id
	 * Can be used for creating an Uri to the file
	 * 
	 * @return
	 */
	public int getDrawableId(){
		return largePhotoDrawableId;
	}
	
	
	
}
